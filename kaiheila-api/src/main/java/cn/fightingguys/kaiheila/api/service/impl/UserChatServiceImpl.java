//package cn.fightingguys.kaiheila.api.service.impl;
//
//import cn.fightingguys.kaiheila.api.domain.*;
//import cn.fightingguys.kaiheila.api.exception.KHLAPIServiceException;
//import cn.fightingguys.kaiheila.api.core.request.RequestTemplate;
//import cn.fightingguys.kaiheila.api.service.UserChatService;
//
//import java.util.List;
//
///**
// * 用户私聊服务
// * Discord 的 DM(Direct Message)
// * <p>
// * 首先创建私聊会话，然后才可以进行私聊
// */
//public class UserChatServiceImpl implements UserChatService {
//
//    public static final String USER_CHAT_URL = "v3/user-chat";
//    public static final String LIST_USER_CHAT_URL = USER_CHAT_URL + "/index";
//    public static final String CREATE_USER_CHAT_URL = USER_CHAT_URL + "/create";
//    public static final String VIEW_USER_CHAT_URL = USER_CHAT_URL + "/view";
//    //    public static final String UPDATE_USER_CHAT_URL = USER_CHAT_URL + "/update";
//    public static final String DELETE_USER_CHAT_URL = USER_CHAT_URL + "/delete";
//    public static final String LIST_MASSAGE_URL = USER_CHAT_URL + "/msg-list";
//    public static final String SEND_MESSAGE_TO_USER_CHAT_URL = USER_CHAT_URL + "/create-msg";
//    public static final String UPDATE_MASSAGE_URL = USER_CHAT_URL + "/update-msg";
//    public static final String DELETE_MASSAGE_URL = USER_CHAT_URL + "/delete-msg";
//    public static final String LIST_REACTION_URL = USER_CHAT_URL + "/reaction-list";
//    public static final String ADD_REACTION_URL = USER_CHAT_URL + "/add-reaction";
//    public static final String DELETE_REACTION_URL = USER_CHAT_URL + "/delete-reaction";
//    private final RequestTemplate requestTemplate;
//
//    public UserChatServiceImpl(RequestTemplate requestTemplate) {
//        this.requestTemplate = requestTemplate;
//    }
//
//    /**
//     * 获取私信聊天会话列表
//     */
//    @Override
//    public List<UserChatInfo> listUserChat() throws KHLAPIServiceException {
//        String url = LIST_USER_CHAT_URL;
//        return null;
//    }
//
//    @Override
//    public UserChatInfoDetail viewUserChat() throws KHLAPIServiceException {
//        String url = VIEW_USER_CHAT_URL;
//        return null;
//    }
//
//    /* 官方暂无接口 */
////    /**
////     * 更新私信聊天会话
////     */
////    public void updateUserChat() throws KHLAPIServiceException {
////        String url = UPDATE_USER_CHAT_URL;
////    }
//
//    /**
//     * 创建私信聊天会话
//     */
//    @Override
//    public UserChatInfoDetail createUserChat() throws KHLAPIServiceException {
//        String url = CREATE_USER_CHAT_URL;
//        return null;
//    }
//
//    /**
//     * 删除私信聊天会话
//     */
//    @Override
//    public void deleteUserChat() throws KHLAPIServiceException {
//        String url = DELETE_USER_CHAT_URL;
//    }
//
//    /**
//     * 获取私信聊天消息列表
//     */
//    @Override
//    public List<MessageInfo> listMessage() throws KHLAPIServiceException {
//        String url = LIST_MASSAGE_URL;
//        return null;
//    }
//
//    /**
//     * 发送私信聊天消息
//     */
//    @Override
//    public ChannelMessageAction sendMessage() throws KHLAPIServiceException {
//        String url = SEND_MESSAGE_TO_USER_CHAT_URL;
//        return null;
//    }
//
//    /**
//     * 更新私信聊天消息
//     */
//    @Override
//    public void updateMessage() throws KHLAPIServiceException {
//        String url = UPDATE_MASSAGE_URL;
//    }
//
//    /**
//     * 删除私信聊天消息
//     */
//    @Override
//    public void deleteMessage() throws KHLAPIServiceException {
//        String url = DELETE_MASSAGE_URL;
//    }
//
//    /**
//     * 获取频道消息某个回应的用户列表
//     */
//    @Override
//    public List<ReactionUserInfo> listReaction() throws KHLAPIServiceException {
//        String url = LIST_REACTION_URL;
//        return null;
//    }
//
//    /**
//     * 给某个消息添加回应
//     */
//    @Override
//    public void addReaction() throws KHLAPIServiceException {
//        String url = ADD_REACTION_URL;
//    }
//
//    /**
//     * 删除消息的某个回应
//     */
//    @Override
//    public void deleteReaction() throws KHLAPIServiceException {
//        String url = DELETE_REACTION_URL;
//    }
//}
