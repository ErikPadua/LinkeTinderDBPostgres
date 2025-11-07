## Design Patterns
- Factory
- Singleton

Foi utilizado o design pattern Factory juntamente com o Singleton, 
para posssibilitar que outros bancos SQL possam vir a ser usados posteriormente sem grande esforço, 
como também para garantir que apenas uma instancia desse banco de dados seja usada durante toda a aplicacação.

## MVC
- Service -> DAO
  - ClasseService -> ClasseDAO
- repository -> util
  - ClasseRepository -> ClasseQueryUtil

Classes e pacotes foram renomeados para seguir corretamente a logica apresentada neles,
e para manter o padrão de arquitetura MVC.