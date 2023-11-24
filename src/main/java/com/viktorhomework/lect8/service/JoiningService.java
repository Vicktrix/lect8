package com.viktorhomework.lect8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class JoiningService{
    
    private ReadService read;
    private String start, middle, end, myCSS;

    @Autowired 
    public JoiningService(@Qualifier("read") ReadService read){
        this.read=read;
        String[] src = this.read.getString("classpath:static/template.html").split("<style></style>");
        start = src[0];
        src = src[1].split("<div class=\"content\"></div>");
        middle = src[0];
        end = src[1];
        myCSS = this.read.getString("classpath:static/myCss.txt");
    }
    public String injectToHTML(String str) {
        StringBuilder sb = new StringBuilder();
        String content = read.getString(str);
        sb
            .append(start)
            .append(myCSS)
            .append(middle)
            .append("<div class=\"content\">")
            .append(content)
            .append("</div>")
            .append(end);
        return sb.toString();
    }
}
