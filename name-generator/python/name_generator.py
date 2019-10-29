#!/usr/bin/python3.7

import random
import os


def parse_name_file(file_name: str) -> list:
    with open(file_name) as name_file:
        parsed_names = []
        split_names = name_file.read().split()
        for i in range(0, len(split_names), 4):
            parsed_names.append(split_names[i])
    return parsed_names


def get_random_name(gender):
    first_name = ''
    if gender == 'male':
        first_name = random.choice(male_names)
    elif gender == 'female':
        first_name = random.choice(female_names)
    else:
        print('Invalid gender')
    last_name = random.choice(last_names)
    print(
        f'Random name: {first_name[0]}{first_name[1:].lower()} {last_name[0]}{last_name[1:].lower()}'
    )


last_names = parse_name_file(os.path.abspath(
    'name-generator/name_data/dist.all.last'))
female_names = parse_name_file(
    os.path.abspath('name-generator/name_data/dist.female.first'))
male_names = parse_name_file(os.path.abspath(
    'name-generator/name_data/dist.male.first'))


get_random_name('male')
get_random_name('female')
