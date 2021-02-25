//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.core.KHLRestApiService;
//import cn.fightingguys.kaiheila.api.domain.ChannelMessageAction;
//import cn.fightingguys.kaiheila.api.domain.MessageInfo;
//import cn.fightingguys.kaiheila.api.domain.ReactionUserInfo;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.MessageService;
//import okhttp3.OkHttpClient;
//
//import java.util.List;
//
//public class MessageServiceImpl implements MessageService {
//
//    public static final String MESSAGE_SERVICE_URL = "v3/message";
//    public static final String LIST_CHANNEL_MESSAGE_URL = MESSAGE_SERVICE_URL + "/list";
//    public static final String SEND_MESSAGE_URL = MESSAGE_SERVICE_URL + "/create";
//    public static final String UPDATE_MESSAGE_URL = MESSAGE_SERVICE_URL + "/update";
//    public static final String DELETE_MASSAGE_URL = MESSAGE_SERVICE_URL + "/delete";
//    public static final String lIST_REACTION_URL = MESSAGE_SERVICE_URL + "/reaction-list";
//    public static final String ADD_REACTION_URL = MESSAGE_SERVICE_URL + "/add-reaction";
//    public static final String DELETE_REACTION_URL = MESSAGE_SERVICE_URL + "/delete-reaction";
//
//    private final RequestTemplate requestTemplate;
//
//    public MessageServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 获取频道聊天消息列表
//     *
//     * @return
//     */
//    public List<MessageInfo> listChannelMessage() throws KHLAPIServiceException {
//        /*
//        "data": {
//            "items": [{
//         */
//        String url = LIST_CHANNEL_MESSAGE_URL;
//        return null;
//    }
//
//    /**
//     * 发送频道聊天消息
//     *
//     * @return
//     */
//    public ChannelMessageAction sendMessage() throws KHLAPIServiceException {
//        String url = SEND_MESSAGE_URL;
//        return null;
//    }
//
//    /**
//     * 更新频道聊天消息
//     */
//    public void updateMessage() throws KHLAPIServiceException {
//        String url = UPDATE_MESSAGE_URL;
//    }
//
//    /**
//     * 删除频道聊天消息
//     */
//    public void deleteMessage() throws KHLAPIServiceException {
//        String url = DELETE_MASSAGE_URL;
//    }
//
//    /**
//     * 获取频道消息某个回应的用户列表
//     */
//    public List<ReactionUserInfo> listReaction() throws KHLAPIServiceException {
//        String url = lIST_REACTION_URL;
//        return null;
//    }
//
//    /**
//     * 给某个消息添加回应
//     */
//    public void addReaction() throws KHLAPIServiceException {
//        String url = ADD_REACTION_URL;
//    }
//
//    /**
//     * 删除消息的某个回应
//     */
//    public void deleteReaction() throws KHLAPIServiceException {
//        String url = DELETE_REACTION_URL;
//    }
//}
