//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.domain.UserInfo;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.UserService;
//
//public class UserServiceImpl implements UserService {
//
//    public static final String USER_SERVICE_URL = "v3/user";
//    public static final String GET_ME_USER_URL = USER_SERVICE_URL + "/me";
//
//    private final RequestTemplate requestTemplate;
//
//
//    public UserServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * <p>
//     * 获取当前登录的用户的信息
//     * </p>
//     *
//     * @return {@see MeUser} 机器人信息
//     * @throws KHLAPIServiceException 用户调用异常
//     */
//    public UserInfo getMeUser() throws KHLAPIServiceException {
////        new List<UserInfo>
//
////        requestTemplate.postForObject(GET_ME_USER_URL, new TypeReference<List<UserInfo>>() {}, null, null);
////        return requestTemplate.getForObject(GET_ME_USER_URL, UserInfo.class, null);
//        return null;
//    }
//}
