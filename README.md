Simple crud rest application which allows to send requests to database.
# API Endpoints 
```
[POST] /name/post
[GET] /name/get?id=
[DELETE] /name/delete?id=
```
*all methods works for companies, departments, employees.*
## /name/post
Send POST request with body to create new entity in database
```
/name/post

{
  "name": "Coca - Cola"
}
```
Returns
```
Company successfully saved
```
## /name/get?id=
Send GET request to get entity with id parameter.
```
/companies/get?id=1
```
Returns
```
{
    "name": "Mcdonalds",
    "departments": [
        {
            "name": "Marketing",
            "employees": [
                {
                    "name": "Tony Stark",
                    "salary": 3
                }
            ]
        }
    ]
}
```

## /name/delete?id=
Send DELETE request with parameter to delete entity from database
```
/companies/delete?id=1
```
Returns
```
Company deleted
```
