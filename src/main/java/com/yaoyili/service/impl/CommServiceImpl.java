package com.yaoyili.service.impl;

import com.yaoyili.controller.ShareInfoResponse;
import com.yaoyili.dao.ShareInfoMapper;
import com.yaoyili.controller.RequestShare;
import com.yaoyili.dao.UserInfoMapper;
import com.yaoyili.model.ShareInfo;
import com.yaoyili.model.UserInfo;
import com.yaoyili.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommServiceImpl implements CommService {

    @Autowired
    private ShareInfoMapper shareInfoMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public List<ShareInfoResponse> getShareList() {
         List<ShareInfo> dataList = shareInfoMapper.getAll();
         List<ShareInfoResponse> res = new ArrayList<>();
         dataList.forEach(item -> {
            UserInfo userInfo =  userInfoMapper.selectByPrimaryKey(item.getUid());
            res.add(new ShareInfoResponse(item.getSid(), item.getUid(),
                    item.getTitle(), item.getPhotoUrl(), userInfo.getName(), userInfo.getPhotoUrl()));
         });

         return res;
    }

    @Override
    public ShareInfoResponse getShareDetail(int sid) {
        ShareInfo info = shareInfoMapper.selectByPrimaryKey(sid);
        UserInfo userInfo =  userInfoMapper.selectByPrimaryKey(info.getUid());
        return new ShareInfoResponse(info.getSid(), info.getUid(),
                info.getTitle(), info.getPhotoUrl(), userInfo.getName(),
                userInfo.getPhotoUrl(), info.getContent());
    }

    @Override
    public void publishShare(RequestShare share) {

        ShareInfo info = new ShareInfo();
        info.setUid(share.getUid());
        info.setPhotoUrl(share.getPhotoUrl());
        info.setTitle(share.getTitle());
        info.setContent(share.getDetail());
        shareInfoMapper.insertSelective(info);
    }
}
