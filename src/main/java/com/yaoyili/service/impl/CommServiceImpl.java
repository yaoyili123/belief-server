package com.yaoyili.service.impl;

import com.yaoyili.dao.ShareDetailMapper;
import com.yaoyili.dao.ShareInfoMapper;
import com.yaoyili.model.RequestShare;
import com.yaoyili.model.ShareDetail;
import com.yaoyili.model.ShareInfo;
import com.yaoyili.service.CommService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommServiceImpl implements CommService {

    @Autowired
    private ShareInfoMapper shareInfoMapper;

    @Autowired
    private ShareDetailMapper shareDetailMapper;

    @Override
    public List<ShareInfo> getShareList() {
        return shareInfoMapper.getAll();
    }

    @Override
    public void publishShare(RequestShare share) {

        ShareInfo info = new ShareInfo();
        info.setUid(share.getUid());
        info.setPhotoUrl(share.getPhotoUrl());
        info.setTitle(share.getTitle());
        shareInfoMapper.insertSelective(info);
        shareDetailMapper.insertSelective(new ShareDetail(info.getSid(), share.getDetail()));
    }
}
