import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConstituentsService {
  public API = '//localhost:8080';
  public CONST_API = this.API + '/const_model';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.CONST_API + "/list");
  }


  getBySos(sosId: number){
    return this.http.get(this.CONST_API + "/from_sos/"+ sosId)
  }

  get(id: number) {
    return this.http.get(this.CONST_API + '/' + id);
  }

  save(model: any): Observable<any> {
    let result: Observable<Object>;
    if (model['href']) {
      result = this.http.put(model.href, model);
    } else {
      console.log(JSON.stringify(model));
      result = this.http.post(this.CONST_API+ "/save", model);
    }
    return result;
  }

  remove(id: number) {
    return this.http.delete(this.CONST_API + '/delete/' + id);
  }
}
