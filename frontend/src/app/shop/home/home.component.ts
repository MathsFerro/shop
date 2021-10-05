import { Component, OnInit } from '@angular/core';
import { ItemData, ShopService } from '../shop.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  items: ItemData[];

  responsiveOptions: any;

  constructor(
    private service: ShopService
  ) { }

  ngOnInit(): void {
    this.service.findAllItems().subscribe(resp => {
      this.items = resp.content;
    }, error => {
      console.log(error);
    })

    this.responsiveOptions = [
      {
          breakpoint: '1024px',
          numVisible: 3,
          numScroll: 3
      },
      {
          breakpoint: '768px',
          numVisible: 2,
          numScroll: 2
      },
      {
          breakpoint: '560px',
          numVisible: 1,
          numScroll: 1
      }
    ];
  }

}
