//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
//import cn.fightingguys.kaiheila.api.domain.IntimacyInfo;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.IntimacyService;
//import okhttp3.OkHttpClient;
//
///**
// * 亲密度
// */
//public class IntimacyServiceImpl implements IntimacyService {
//
//    public static final String INTIMACY_URL = KHLRestApiService.API_ENDPOINT_BASE_URL + "v3/intimacy";
//    public static final String GET_USER_INTIMACY_URL = INTIMACY_URL + "/index";
//    public static final String UPDATE_USER_INTIMACY_URL = INTIMACY_URL + "/update";
//
//    private final RequestTemplate requestTemplate;
//
//    public IntimacyServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 获取用户的亲密度
//     */
//    public IntimacyInfo getUserIntimacy() throws KHLAPIServiceException {
//        String url = GET_USER_INTIMACY_URL;
//        return null;
//    }
//
//    /**
//     * 更新用户的亲密度
//     */
//    public void updateUserIntimacy() throws KHLAPIServiceException {
//        String url = UPDATE_USER_INTIMACY_URL;
//    }
//}
