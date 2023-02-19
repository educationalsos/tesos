import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ComunicationalCapability } from './comunicationalCapability';

@Injectable({
  providedIn: 'root'
})
export class ComunicationalCapabilitiesService {
  public API = '//localhost:8080';
  public CONST_API = this.API + '/cm_capability';

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    return this.http.get(this.CONST_API + "/list");
  }

  get(id: number) {
    return this.http.get(this.CONST_API + '/' + id);
  }

  save(cm_capability: ComunicationalCapability): Observable<any> {
    let result: Observable<Object>;
    result = this.http.post(this.CONST_API+ "/save", cm_capability);
    return result;
  }

  update(cm_capability: ComunicationalCapability){
    let result: Observable<Object>;
    result = this.http.post(this.CONST_API+ "/update/" + cm_capability.id, cm_capability);
    return result;
  }

  remove(id: number) {
    return this.http.delete(this.CONST_API + '/delete/' + id);
  }
}
