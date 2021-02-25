//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
//import cn.fightingguys.kaiheila.api.domain.GuildInfo;
//import cn.fightingguys.kaiheila.api.domain.GuildUsersInfo;
//import cn.fightingguys.kaiheila.api.domain.UserInfo;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.GuildService;
//import okhttp3.OkHttpClient;
//
//import java.util.List;
//
//public class GuildServiceImpl implements GuildService {
//
//    public static final String GUILD_SERVICE_URL = "v3/guild";
//    public static final String LIST_JOINED_GUILD_URL = GUILD_SERVICE_URL + "/list";
//    public static final String LIST_USER_LIST_URL = GUILD_SERVICE_URL + "/user-list";
//    public static final String CHANGE_USER_NICK_NAME_URL = GUILD_SERVICE_URL + "/nickname";
//    public static final String LEAVE_GUILD_URL = GUILD_SERVICE_URL + "/leave";
//    public static final String KICK_USER_URL = GUILD_SERVICE_URL + "/kickout";
//    public static final String LIST_GUILD_MUTE_URL = GUILD_SERVICE_URL + "-mute/list";
//    public static final String MUTE_USER_URL = GUILD_SERVICE_URL + "-mute/create";
//    public static final String UNMUTE_USER_URL = GUILD_SERVICE_URL + "-mute/delete";
//
//    private final RequestTemplate requestTemplate;
//
//    public GuildServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 当前机器人已经加入的服务器列表
//     */
//    public List<GuildInfo> listJoinedGuild() throws KHLAPIServiceException {
//        String url = LIST_JOINED_GUILD_URL;
//        //return requestTemplate.getForObject(url, List<GuildInfo>.class, null);
//        return null;
//    }
//
//    /**
//     * 获取当前服务器用户列表
//     */
//    public GuildUsersInfo listUserList() throws KHLAPIServiceException {
//        String url = LIST_USER_LIST_URL;
//        return null;
//    }
//
//    /**
//     * 修改某个服务器的用户名称
//     */
//    public void changeUserNickname() throws KHLAPIServiceException {
//        String url = CHANGE_USER_NICK_NAME_URL;
//    }
//
//    /**
//     * 机器人用户离开服务器
//     */
//    public void leaveGuild() throws KHLAPIServiceException {
//        String url = LEAVE_GUILD_URL;
//    }
//
//    /**
//     * 从某个服务器提出用户
//     */
//    public void kickUser() throws KHLAPIServiceException {
//        String url = KICK_USER_URL;
//    }
//
//    /**
//     * 获取某个服务器的禁言列表
//     */
//    public void listGuildMute() throws KHLAPIServiceException {
//        String url = LIST_GUILD_MUTE_URL;
//        // todo 奇怪的接口增加了？
//    }
//
//    /**
//     * 禁言某个服务器的用户
//     */
//    public void muteUser() throws KHLAPIServiceException {
//        String url = MUTE_USER_URL;
//    }
//
//    /**
//     * 解除禁言某个服务器的用户
//     */
//    public void unmuteUser() throws KHLAPIServiceException {
//        String url = UNMUTE_USER_URL;
//    }
//}
