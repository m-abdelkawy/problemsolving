import json

class Library:
    def __init__(self, name: str, address:str, book_count: int):
        self.name = name
        self.address = address
        self.book_count = book_count
            

class User:
    
    def __init__(self, name:str, age:int):
        self.name = name
        self.age = age
    
    def encode_user(self):
        if isinstance(self, User):
            return {"name": self.name, "age": self.age, self.__class__.__name__: True}
        else:
            raise TypeError("the object is not of type %s", User.__name__)
        

def encode_user(obj):
    if isinstance(obj, User):
        return {"name": obj.name, "age": obj.age, obj.__class__.__name__: True}
    else:
        raise TypeError("the object is not of type %s", User.__name__)

def decode_user(dct):
    if User.__name__ in dct:
        return User(name=dct["name"], age=dct["age"])
    else:
        return dct

        
if __name__ == "__main__":
    user = User("Mohammed", 35)
    
    userJson = json.dumps(user, default=encode_user)
    print(userJson)
    
    user_decoded = json.loads(userJson, object_hook=decode_user)
    print(type(user_decoded))
    print(user_decoded.name)
    