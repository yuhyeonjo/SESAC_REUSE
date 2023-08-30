package com.sesac.reuse.model.entity;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class UploadFile {

    private List<MultipartFile> files;

}
