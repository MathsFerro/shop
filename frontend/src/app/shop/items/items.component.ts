import { Component, OnInit } from '@angular/core';
import { ItemData, ShopService } from '../shop.service';
@Component({
  selector: 'app-items',
  templateUrl: './items.component.html',
  styleUrls: ['./items.component.scss']
})
export class ItemsComponent implements OnInit {

  items: ItemData[] = [];

  constructor(
    private service: ShopService
  ) { }

  ngOnInit(): void {
    this.findAllItems();
  }

  findAllItems() {
    this.service.findAllItems().subscribe(resp => {
      this.items = resp.content;
      console.log(this.items);
      console.log(resp);
    }, error => {
      console.log(error);
    });

  }

  addItem(item: ItemData) {
    console.log(item);
  }

}
