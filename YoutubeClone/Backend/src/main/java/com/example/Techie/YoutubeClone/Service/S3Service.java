package com.example.Techie.YoutubeClone.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service implements fileService{

    public static final String BUCKET_NAME = "nisanga";
    private final AmazonS3Client awsS3Client;

    @Override
    public String uploadFile(MultipartFile file){

   var filename =     StringUtils.getFilenameExtension(file.getOriginalFilename());
    var key =  UUID.randomUUID().toString() + "." + filename;
    var metadata = new ObjectMetadata();
    metadata.setContentLength(file.getSize());
    metadata.setContentType(file.getContentType());

    try {
        awsS3Client.putObject(BUCKET_NAME, key, file.getInputStream(), metadata);
    }catch(IOException ioException){
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,"An exception occurred");
    }
    awsS3Client.setObjectAcl(BUCKET_NAME,key, CannedAccessControlList.PublicRead);
    return awsS3Client.getResourceUrl(BUCKET_NAME,key);
    }
}
