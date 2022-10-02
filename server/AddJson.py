import json

path = 'game_list.json'
available_categories = {
    'EVENT' : None,
    'AGE' : None,
    'GAME_TYPE' : {
        'ONLINE' : None,
        'OFFLINE' : None,
    },
    'PERSONS_COUNT' : None,
    'DIFFICULTY' : None, 
    'TIME' : None
}

class AddApp:
    def __init__(self, name="", url="", desc="", categories={}, id = int()):
        self.name = name
        self.url = url
        self.desc = desc
        self.categories = categories
        self.id = id
    def write(self):
        data = {
            'NAME' : self.name,
            'URL' : self.url,
            'DESC' : self.desc, 
            'CATEGORIES' : self.categories,
            'ID' : self.id,
        }
        return data


if __name__ == '__main__':
    with open(path, 'r', encoding='utf-8') as file:
        data = json.loads(file.read())
    with open(path, 'w', encoding='utf-8') as file:
        try:
            if (len(data) != 0 and 'ID' in data[-1]):
                id = data[-1]['ID'] + 1
            else:
                id = 1
            ctg = available_categories.copy()
            ctg['EVENT'] = ['party', 'family', 'child']
            ctg['AGE'] = 6
            ctg['GAME_TYPE']['ONLINE']
            ctg['GAME_TYPE']['OFFLINE'] = ['true']

            name = f'Дабл Слинг'
            url = f'https://www.ozon.ru/product/derevyannaya-nastolnaya-igra-dlya-razvitiya-lovkosti-dabl-sling-s-tsvetnymi-fishkami-double-sling-172894782/?asb=kmQ5CUWCAt5V5CR9Z38YwjAM327iUzFlxqUcDvvSwv2YsQWzSpBh1n2SO2tOSDCI&asb2=wYQpSqgO6xfrE55fy8ZWozcODghhwnfzFzulVT9BqraFI9YDQYa5et9vVbYDqW6dOzbvft7GZyLRibmM7b_cAOwNhyLKbPoQyC2DQ8Zhsbv-Q01kJWFkg4Gwabc4971OM33iXGMQ21O4TViU2jG9CA&sh=rkEx2jfshg'
            desc = f'Сразитесь с соперником в увлекательной активной настольной игре «Дабл Cлинг»!Состав игры:игровое поле (43,3 х 25 см, высота – 33 мм)деревянные фишки – 10 шт. (диаметр – 29 мм., высота – 12 мм)Цель игры – первым выбить все фишки своего цвета на сторону противника. Для этого необходимо натянуть фишку на резинку, прицелиться и отправить её прямо через центральные ворота на половину противника! Тот, кто сделает это быстрее, становится победителем игры.'
            app = AddApp(name, url, desc, ctg, id)
            data.append(app.write())
        except:
            pass
        finally:
            json.dump(data, file, indent=4, sort_keys=True, separators=(',', ' : '), ensure_ascii=False)

