import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  public API = '//localhost:8080';
  public CONST_API = this.API + '/services';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.CONST_API + "/list");
  }

  get(id: number) {
    return this.http.get(this.CONST_API + '/' + id);
  }

  save(serv: any): Observable<any> {
    let result: Observable<Object>;
    if (serv['href']) {
      result = this.http.put(serv.href, serv);
    } else {
      console.log(JSON.stringify(serv))
      result = this.http.post(this.CONST_API+ "/save", serv);
    }
    return result;
  }

  remove(id: number) {
    return this.http.delete(this.CONST_API + '/delete/' + id);
  }
}
