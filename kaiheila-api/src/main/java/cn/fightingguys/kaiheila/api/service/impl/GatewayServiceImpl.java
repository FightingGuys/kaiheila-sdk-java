//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
//import cn.fightingguys.kaiheila.api.domain.RemoteURL;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.GatewayService;
//import okhttp3.OkHttpClient;
//
//public class GatewayServiceImpl implements GatewayService {
//
//    public static final String GATEWAY_URL = "v3/gateway";
//    public static final String GET_WEB_SOCKET_GATEWAY_URL = GATEWAY_URL + "/index";
//
//    private final RequestTemplate requestTemplate;
//
//    public GatewayServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 获取网关连接地址
//     *
//     * @return {@link RemoteURL} 网关的连接地址
//     * @throws {@link KHLAPIServiceException}
//     */
//    public RemoteURL getWebSocketGateway() throws KHLAPIServiceException {
//        String url = GET_WEB_SOCKET_GATEWAY_URL;
//        return null;
//    }
//
//}
