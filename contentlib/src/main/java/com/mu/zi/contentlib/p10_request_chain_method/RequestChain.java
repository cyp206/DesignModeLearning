package com.mu.zi.contentlib.p10_request_chain_method;

/**
 * 责任链模式
 * 后台喜欢封装，连一个level也需要进行封装了。
 * 元素包括 Request  Response Level  handler
 * 多个handler构成责任链
 * handler中 handleMessage 处理请求与响应。满足level条件的话 调用echo方法返回response
 * handler中的getHandlerlevel 获得的是当前handler的level。
 * <p>
 * <p>
 * <p>
 * Created by y on 2018/1/12.
 */

public class RequestChain {


    public RequestChain() {
        Request request = new Request4();
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2();
        Handler handler3 = new Handler3();
        Handler handler4 = new Handler4();

        handler1.setNextHandler(handler2);
        handler2.setNextHandler(handler3);
        handler3.setNextHandler(handler4);


        Response response = handler1.handleMessage(request);
        if (response != null) {
            response.doResponse();
        }


    }


    public abstract class Request {


        public abstract Level getHandlerLevel();


    }

    public class Request4 extends Request {

        @Override
        public Level getHandlerLevel() {
            return new Level("4");
        }
    }


    public class Response {
        String leve;

        public Response(String leve) {
            this.leve = leve;

        }

        public void doResponse() {
            System.out.println("响应等级==》" + leve);

        }
    }

    public class Level {
        String level;

        public Level(String level) {
            this.level = level;
        }

    }


    public abstract class Handler {

        Handler nextHandler;


        final public Response handleMessage(Request request) {

            Response response = null;
            if (getHandlerLevel().level.equals(request.getHandlerLevel().level)) {
                response = echo(request);
            } else {
                if (nextHandler != null) {
                    response = nextHandler.handleMessage(request);
                }
            }
            return response;

        }

        public abstract Level getHandlerLevel();


        protected Response echo(Request request) {
            return new Response(request.getHandlerLevel().level);

        }

        public void setNextHandler(Handler handler) {
            this.nextHandler = handler;
        }

    }

    public class Handler1 extends Handler {

        @Override
        public Level getHandlerLevel() {
            return new Level("1");
        }
    }

    public class Handler2 extends Handler {

        @Override
        public Level getHandlerLevel() {
            return new Level("2");
        }
    }

    public class Handler3 extends Handler {

        @Override
        public Level getHandlerLevel() {
            return new Level("3");
        }
    }

    public class Handler4 extends Handler {

        @Override
        public Level getHandlerLevel() {
            return new Level("4");
        }
    }


}
