package netty.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.util.CharsetUtil;
import org.apache.log4j.Logger;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_0;
import static io.netty.handler.codec.rtsp.RtspHeaders.Names.CONTENT_TYPE;
import static io.netty.handler.codec.rtsp.RtspResponseStatuses.BAD_REQUEST;
import static io.netty.handler.codec.rtsp.RtspResponseStatuses.OK;

/**
 * 处理具体的HTTP文件请求业务
 */
public class SimpleHttpFileServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{

    private static Logger logger = Logger.getLogger(SimpleHttpFileServerHandler.class);
    private final String path ;

    public SimpleHttpFileServerHandler(String path) {
        this.path = path;
    }

    protected void messageReceived(ChannelHandlerContext channelHandlerContext,
                                   FullHttpRequest request) throws Exception {
        System.out.println("Server receive request:"+request.getUri());
        if(!request.getDecoderResult().isSuccess()){
            sendError(channelHandlerContext,BAD_REQUEST);
        }

        String content = "success: \\r\\n";
        FullHttpResponse response =
                new DefaultFullHttpResponse(HTTP_1_0, OK,
                        Unpooled.copiedBuffer(content.getBytes()));
        response.headers().set(CONTENT_TYPE,"text/patin;  CharsetUtil.UTF_8");
        channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    private void sendError(ChannelHandlerContext ctx, HttpResponseStatus status) {
        String content = "Failure: "+status.toString()+"\\r\\n";
        FullHttpResponse response =
                new DefaultFullHttpResponse(HTTP_1_0, status,
                        Unpooled.copiedBuffer(content.getBytes()));
        response.headers().set(CONTENT_TYPE,"text/patin;  CharsetUtil.UTF_8");
        ctx.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
    }

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, FullHttpRequest request) throws Exception {

    }
}
