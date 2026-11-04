
def start_end_decorator(func):
    def wrapper(name:str):
        print("Hello")
        func(name)
        print("goodbye")
    return wrapper

@start_end_decorator
def print_name(name:str):
    print(name)
    
# greet = start_end_decorator(print_name, "Mohammed")

# greet()

# print("\n")

print_name("Mohammed")