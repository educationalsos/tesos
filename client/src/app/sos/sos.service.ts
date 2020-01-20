import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class SosService {
  public API = '//localhost:8080';
  public SOS_API = this.API + '/sos';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.SOS_API + "/list");
  }

  get(id: number) {
    return this.http.get(this.SOS_API + '/' + id);
  }

  save(sos: any): Observable<any> {
    let result: Observable<Object>;
    if (sos['href']) {
      result = this.http.put(sos.href, sos);
    } else {
      result = this.http.post(this.SOS_API+ "/save", sos);
    }
    return result;
  }

  remove(id: number) {
    return this.http.delete(this.SOS_API + '/delete/' + id);
  }

  upload(file: FormData){
    return this.http.post(this.SOS_API +"/upload_file", file);
  }

}
