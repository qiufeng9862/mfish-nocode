package cn.com.mfish.oauth.service;

import cn.com.mfish.common.oauth.api.entity.UserInfo;
import cn.com.mfish.common.oauth.api.vo.UserInfoVo;
import cn.com.mfish.common.oauth.entity.AuthorizationCode;
import cn.com.mfish.common.oauth.entity.RedisAccessToken;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

/**
 * @author: mfish
 * @date: 2020/2/13 12:51
 */
public interface OAuth2Service {
    AuthorizationCode buildCode(OAuthAuthzRequest request) throws OAuthSystemException;

    void setCode(AuthorizationCode code);

    void delCode(String code);

    AuthorizationCode getCode(String code);

    RedisAccessToken buildToken(OAuthTokenRequest request) throws OAuthSystemException;

    RedisAccessToken code2Token(OAuthTokenRequest request, AuthorizationCode code) throws OAuthSystemException;

    RedisAccessToken refresh2Token(RedisAccessToken token) throws OAuthSystemException;

    UserInfo getUserInfo(String userId);

    UserInfoVo getUserInfoAndRoles(String userId, String clientId);

    String getCurrentUser();

}
