package com.yaoyili.service;

import com.yaoyili.controller.RequestShare;
import com.yaoyili.controller.ShareInfoResponse;
import com.yaoyili.model.ShareInfo;

import java.util.List;

public interface CommService {

    List<ShareInfoResponse> getShareList();

    void publishShare(RequestShare shareDetail);

    ShareInfoResponse getShareDetail(int sid);
}
