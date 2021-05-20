from django.shortcuts import render

import os


# Create your views here.

def hello_world(request):
    print(os.getcwd())
    return render(
        request,
        "index.html"
    )


def get_index(request):
    api_change = []
    title = []
    head = True
    with open("./result/api_change.csv", 'r') as file:
        for line in file.readlines():
            if head:
                title = line.split(',')
                head = False
            else:
                api_change.append(line.split(','))

    return render(
        request,
        "index.html",
        {
            "title": title,
            "api_change": api_change
        }
    )


def get_detail(request, ID):
    details = "codes/" + str(ID) + "/result.html"
    return render(
        request,
        details
    )
