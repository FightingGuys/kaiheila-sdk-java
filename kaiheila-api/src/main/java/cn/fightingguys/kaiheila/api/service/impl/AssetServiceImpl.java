//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
//import cn.fightingguys.kaiheila.api.domain.RemoteURL;
//import cn.fightingguys.kaiheila.api.domain.UserInfo;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.AssetService;
//import okhttp3.OkHttpClient;
//
//public class AssetServiceImpl implements AssetService {
//
//    public static final String ASSET_SERVICE_URL = "v3/asset";
//    public static final String CREATE_ASSET_URL = ASSET_SERVICE_URL + "/create";
//
//    private final RequestTemplate requestTemplate;
//
//    public AssetServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 上传文件/图片
//     *
//     * @return {@link RemoteURL} 服务器返回的url
//     * @throws {@link KHLAPIServiceException}
//     */
//    public RemoteURL createAsset() throws KHLAPIServiceException {
//        return null;
//    }
//}
