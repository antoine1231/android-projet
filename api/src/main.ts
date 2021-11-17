import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';
import { CarModule } from './car.module';



async function bootstrap() {
  const app = await NestFactory.create(CarModule);
  await app.listen(8080);
}
bootstrap();
