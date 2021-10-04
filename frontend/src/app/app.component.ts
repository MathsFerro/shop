import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'mycart';

  items: MenuItem[] = [];
  activeItem: MenuItem;

  constructor(
    private route: Router
  ) { }

  ngOnInit() {
    this.items = [
      { label: "Home", icon: "pi pi-fw pi-home", command: () => this.route.navigate(["/"]) },
      { label: "Item", icon: "pi pi-fw pi-list", command: () => this.route.navigate(["/items"]) },
      { label: "Carrinho", icon: "pi pi-shopping-cart", command: () => this.route.navigate(["/cart"]) }
    ];
   
    this.activeItem = this.items[0];
  }
}
