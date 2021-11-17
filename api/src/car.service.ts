import { Injectable } from '@nestjs/common';
import { Car } from './car';
import * as data from './cars_dataset.json';


@Injectable()
export class CarService {
    cars: Car[] = <Car[]>(<unknown>data);

    //function to get all the cars of the Dataset
    getAll() : Car[] {
        return this.cars;
    }
    //function to add a car in on the dataset
    createcar(car:Car): Car |string {
        for(let i = 0; i < (this.cars.length);i++){
            if (this.cars[i]===car){
                return "Car already exists in the DataBase";
            }
        }
        this.cars.push(car);
        return car;
    }
    //function to return a car by its name
    getCarByName(name: string){
        return this.cars.find(car => car.name === name)
    }

    getCarsFrom(origin: string) : Car[] | undefined {
        let getCarsFrom: Car[]=[];
        for(let i = 0; i < (this.cars.length);i++){
            if (this.cars[i].origin===origin){
                getCarsFrom.push(this.cars[i]);
            }
        }
        return getCarsFrom;
    }

    deletecarsByName(name:string){
        let newTab: Car[]=[];
        for(let i = 0; i < (this.cars.length);i++){
            if (this.cars[i].name!==name)
                newTab.push(this.cars[i]);
        }
        this.cars=newTab;
        return this.cars;
    }

    setFavori(name:string){
        this.cars.find(car => car.name === name).favorite=!this.cars.find(car => car.name === name).favorite
    }
}

