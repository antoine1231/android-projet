import { Body, Controller, Delete, Get, Param, Post, Put, Query } from '@nestjs/common';
import { CarService } from './car.service';
import { Car } from './car';
import { query } from 'express';

@Controller('/cars')
export class CarController {
  constructor(private readonly carService: CarService) {}


  @Get()
  getcars(@Query('author') author: string){
    if(author===undefined) return this.carService.getAll();
    return this.carService.getCarsFrom(author);
  }

  @Post()
  createcar(@Body() car : Car){
    return this.carService.createcar(car);
  }
  
  @Get(':id')
  getcarByTitle(@Param('id') id: string){
    return this.carService.getCarByName(id);
  }

  @Put(':id')
  setFavori(@Param('id') id: string){
    this.carService.setFavori(id);
  }

  @Delete(':id')
  deletecarsByTitle(@Param('id') id: string){
    return this.carService.deletecarsByName(id);
  }

}
