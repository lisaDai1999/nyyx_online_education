package com.jiaobuqifangzu.nyyx.controller;

import com.jiaobuqifangzu.nyyx.dao.repository.VideoRepository;
import com.jiaobuqifangzu.nyyx.domain.Video;
import com.jiaobuqifangzu.nyyx.entityForReturn.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ChenXing
 * @date 2020/10/12 14:05
 */
@RestController
@RequestMapping("/video")
public class VideoHandler {
    @Autowired
    VideoRepository videoRepository;


    /**
     * @param course_id
     * @return
     * 编写人：陈星
     * 日期：2020/10/18
     * 输入说明：课程id
     * 输出说明：请求是否成功信息
     * 功能简述：根据课程id返回响应的视频列表
     */
    @GetMapping("/all")
    public VideoListReturn getVideoList(@RequestParam(value = "course_id") int course_id) {
        VideoListReturn videoListReturns = new VideoListReturn();
        List<Video> reTemp = videoRepository.findAllByCourse_id(course_id);
        if (reTemp.size() > 0) {
            List<VideoReturn> res = new ArrayList<>();
            for (Video v : reTemp) {
                VideoReturn videoReturn = new VideoReturn(v.getId(), v.getCover_route(), v.getVideo_title(), v.getBrief_introduction());
                res.add(videoReturn);
            }
            videoListReturns.setCode(0);
            videoListReturns.setMsg("视频信息获取成功");
            videoListReturns.setData(res);
            return videoListReturns;
        } else {

            videoListReturns.setCode(1);
            videoListReturns.setMsg("视频信息获取失败");
        }
        return videoListReturns;
    }

    /**
     *
     * @param id
     * @return
     * 编写人：陈星
     * 日期：2020/10/22
     * 输入说明：视频id
     * 输出说明：视频信息
     * 功能简述：查询视频信息
     */

    @GetMapping("/search")
    public VideoInfoReturn getVideoInfo(@RequestParam(value = "id") int id) {
        VideoInfoReturn videoInfoReturn = new VideoInfoReturn();
        Video reV = videoRepository.findVideoById(id);
        if (reV != null) {
            videoInfoReturn.setCode(0);
            videoInfoReturn.setMsg("视频消息获取成功！");
            videoInfoReturn.setData(new VideoInfo(reV.getVideo_route(), reV.getCover_route(), reV.getVideo_title(), reV.getBrief_introduction()));
        } else {
            videoInfoReturn.setCode(1);
            videoInfoReturn.setMsg("视频消息获取失败！");
        }
        return videoInfoReturn;
    }


    /**
     * 上传视频
     *
     * @param video
     * @return
     * 编写人：陈星
     * 日期：2020/10/18
     * 输入说明：视频信息
     * 输出说明：存储成功信息
     * 功能简述：数据库video添加一条数据
     */
    @PostMapping("/uploadVideo")
    public LoginReturn uploadVideo(@RequestBody Video video) {
        Date data = new Date();
        video.setCreateTime(data);
        try {
            videoRepository.save(video);
            return new LoginReturn(0, "视频上传成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new LoginReturn(1, "视频上传失败");
    }
}
