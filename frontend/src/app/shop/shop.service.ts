import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Pageable } from 'src/utils/Pageable';

@Injectable({
  providedIn: 'root'
})
export class ShopService {

  devUrl = "http://localhost:8080/api";

  constructor(
    private http: HttpClient
  ) { }

  findAllItems(): Observable<Pageable> {
    return this.http.get<Pageable>(this.devUrl+"/item");
  }

  findById(id: number): Observable<ItemData> {
    return this.http.get<ItemData>(this.devUrl+`/item/${id}`);
  }

}

export interface ItemData {
  id: number;
  name: string;
  description: string;
  price: number;
  createdAt: Date;
  updatedAt: Date;
}
