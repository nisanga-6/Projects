import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class VideoServiceService {

  constructor(private httpClient: HttpClient) { }

  // @ts-ignore
  uploadVideo(fileEntry: File):Observable<any>{

    const formData = new FormData();
    formData.append('file',fileEntry,fileEntry.name);
    //http post call
    this.httpClient.post("http://localhost:8080/api/videos/",formData);
  }
}
