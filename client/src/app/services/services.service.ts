import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Service } from './service';

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
    result = this.http.post(this.CONST_API+ "/save", serv);
    return result;
  }

  update(serv: Service): Observable<any> {
    let result: Observable<Object>;
    console.log("url", this.CONST_API+ "/update/" + serv.id)
    result = this.http.post(this.CONST_API+ "/update/" + serv.id, serv);
    return result;
  }

  update_all(serv: Array<Service>): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(this.CONST_API+ "/update_all", serv);
    return result;
  }


  remove(id: number) {
    return this.http.delete(this.CONST_API + '/delete/' + id);
  }
}
