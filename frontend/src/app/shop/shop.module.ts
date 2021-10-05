import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

import { CardModule } from 'primeng/card';
import { ButtonModule } from 'primeng/button';
import { ShopRoutingModule } from './shop-routing.module';
import { HomeComponent } from './home/home.component';
import { ItemsComponent } from './items/items.component';
import { ShopService } from './shop.service';
import { CartComponent } from './cart/cart.component';


@NgModule({
  declarations: [
    HomeComponent,
    ItemsComponent,
    CartComponent
  ],
  imports: [
    CommonModule,
    ShopRoutingModule,
    HttpClientModule,
    CardModule,
    ButtonModule
  ],
  providers: [
    ShopService
  ]
})
export class ShopModule { }
