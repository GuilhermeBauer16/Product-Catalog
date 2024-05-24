# Product Catalog                                          
                       
## Objective              
A product catalog where the user can store, see, delete, and edit the products to keep them more organized. The fields to register are name, price, branch, category, description, and quantity.

## Working example.                 

![Screenshot from 2024-01-30 19-55-07](https://github.com/GuilhermeBauer16/Product-Catalog/assets/123701893/c4d0917c-3584-461c-a740-5db62acf529f)

![Screenshot from 2024-01-30 19-59-06](https://github.com/GuilhermeBauer16/Product-Catalog/assets/123701893/c7068a67-0dfe-479f-abf2-c6c8f37c8d8c)    



## Learnings 

In that project, I learned how to use the concept of VO(Value Object) to not expose the original entity, instead of using the VO class that looks like a mirror of that original entity to make the database transition more secure for don't expose the data of the original entity, for help me to make that I use the dependency Model mapper. I also learned that my project supports more than one data serialization, supported JSON, YAML, and XML via header. I use the dependency Jackson data format to make that. I also learned to use UUID and how to Primary key instead of long or big int in my tables for more security.


### Product
* Addition of product divided between:    
  * name.
  * price.
  * description.
  * category.
  * branch.
  * quantity.
   
* Registered product edition.     
  
* Deletion of product.

* Viewing registered product.

 ### Category

* Addition of category.   
  
  
* Registered category edition.     
  
* Deletion of category.

* Viewing registered category.

## Swagger
* link: http://localhost:8080/swagger-ui/index.html

 
  * If the operation system is Linux, don't forget to put sudo before docker.

## Dependencies that I used in the project

### Model mapper

![Screenshot from 2024-01-30 19-49-21](https://github.com/GuilhermeBauer16/Product-Catalog/assets/123701893/eacda546-b024-4f92-86a2-5ea858b71e92)

### Jackson data format

#### YAML
![Screenshot from 2024-01-30 19-52-26](https://github.com/GuilhermeBauer16/Product-Catalog/assets/123701893/f2226aa7-c35f-44b4-8278-cfefa2fc5eb1)

#### XML

![Screenshot from 2024-01-30 19-52-15](https://github.com/GuilhermeBauer16/Product-Catalog/assets/123701893/5978a008-95bb-4d23-afd5-2fa8f3da820d)

## Author
 www.linkedin.com/in/guilherme-bauer-desenvolvedor






