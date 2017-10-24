package com.gfc.newfilemanager.controller;

import com.alibaba.fastjson.JSON;
import com.gfc.newfilemanager.dmo.dto.MessageShow;
import com.gfc.newfilemanager.dmo.dto.MessageShowView;
import com.gfc.newfilemanager.dmo.dto.UIModel;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by GFC on 2017/10/13.
 */
public class FileDownLoad extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UIModel uiModel = getUIModel();
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        String file_path = request.getParameter("file_path");
        String path = "E:\\工作文件\\开发文档内容\\";
        if (file_path != null) {
            path = "E:\\工作文件\\开发文档内容\\" + file_path;
        }
        InputStream inputStream = null;
        ServletOutputStream out = null;
        try {
            File file = new File(path);
            String odexName = file.getName();
            int fSize = Integer.parseInt(String.valueOf(file.length()));
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/x-download");
            response.setHeader("Accept-Ranges", "bytes");
            response.setHeader("Content-Length", String.valueOf(fSize));
            response.setHeader("Content-Disposition", "attachment;fileName=" + odexName);
            inputStream = new FileInputStream(path);
            long pos = 0;
            if (null != request.getHeader("Range")) {
                // 断点续传
                response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
                try {
                    pos = Long.parseLong(request.getHeader("Range").replaceAll("bytes=", "").replaceAll("-", ""));
                } catch (NumberFormatException e) {
                    pos = 0;
                }
            }
            out = response.getOutputStream();
            String contentRange = new StringBuffer("bytes ").append(pos + "").append("-").append((fSize - 1) + "").append("/").append(fSize + "").toString();
            response.setHeader("Content-Range", contentRange);
            inputStream.skip(pos);
            byte[] buffer = new byte[1024 * 1000];
            int length = 0;
            while ((length = inputStream.read(buffer, 0, buffer.length)) != -1) {
                out.write(buffer, 0, length);
                Thread.sleep(100);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != out) out.flush();
                if (null != out) out.close();
                if (null != inputStream) inputStream.close();
            } catch (IOException e) {
            }
        }

        String jsonStr = JSON.toJSONString(uiModel);
        PrintWriter outStr = null;
        try {
            outStr = response.getWriter();
            outStr.write(jsonStr);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outStr != null) {
                outStr.close();
            }
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
