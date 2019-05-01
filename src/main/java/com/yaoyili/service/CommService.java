package com.yaoyili.service;

import com.yaoyili.model.RequestShare;
import com.yaoyili.model.ShareDetail;
import com.yaoyili.model.ShareInfo;

import java.util.List;

public interface CommService {

    List<ShareInfo> getShareList();

    void publishShare(RequestShare shareDetail);
}
