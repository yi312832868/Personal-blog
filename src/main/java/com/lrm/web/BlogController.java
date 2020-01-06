package com.lrm.web;

import com.lrm.po.Blog;
import com.lrm.service.BlogService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BlogController {

    private BlogService blogService;
    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, Blog blog, Model model){
        model.addAttribute("page", blogService.listBlog(pageable,blog));
        return "admin/blogs";
    }

    @GetMapping("/blogs/search")
    public String search(@PageableDefault(size = 3, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable, Blog blog, Model model){
        model.addAttribute("page", blogService.listBlog(pageable,blog));
        return "admin/blogs :: blogList";
    }

}
