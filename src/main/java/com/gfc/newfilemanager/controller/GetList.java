package com.gfc.newfilemanager.controller;

import com.alibaba.fastjson.JSON;
import com.gfc.newfilemanager.common.FileInfo;
import com.gfc.newfilemanager.dmo.dto.MessageShow;
import com.gfc.newfilemanager.dmo.dto.MessageShowView;
import com.gfc.newfilemanager.dmo.dto.UIModel;
import com.gfc.newfilemanager.dmo.entity.Pager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by GFC on 2017/10/13.
 */
public class GetList extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UIModel uiModel = getUIModel();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        String file_path = request.getParameter("file_path");
        String path = "E:\\工作文件\\开发文档内容\\";
        if (file_path != null) {
            path = "E:\\工作文件\\开发文档内容\\" + file_path;
        }
        List<FileInfo> aa = getFileInfoList(path);
        Pager<FileInfo> pager = new Pager<>();
        pager.setDatas(aa);
        pager.setCurrentPage(1);
        pager.setPageSize(5);
        pager.setTotalCount(1);
        uiModel.setData(pager);
        String jsonStr = JSON.toJSONString(uiModel);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    private static List<FileInfo> getFileInfoList(String path) {

        List<FileInfo> list = new LinkedList<>();

        File file = new File(path);

        if(!file.exists()){
            throw new IllegalArgumentException("目录："+path+"不存在");
        }

        if (file.isFile()) {
            throw new RuntimeException("不是文件夹");
        } else {

            File[] files = file.listFiles();

            //循环遍历
            for (File  filei:files) {
                FileInfo fileInfo = new FileInfo();
                fileInfo.setName(filei.getName());
                fileInfo.setCapacity(filei.length() + "");
                fileInfo.setUpdateDate(new Date(filei.lastModified()));
                if (filei.isFile()) {
                    fileInfo.setType("file");
                } else {
                    fileInfo.setType("folder");
                }
                list.add(fileInfo);
            }

            return list;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    private UIModel getUIModel() {
        UIModel uiModel = new UIModel();
        uiModel.setMsgView(new MessageShowView());
        uiModel.getMsgView().setMsgdatas(new ArrayList<MessageShow>(3));
        return uiModel;
    }

}
