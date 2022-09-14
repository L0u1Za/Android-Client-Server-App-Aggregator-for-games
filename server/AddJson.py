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
            ctg['EVENT'] = ['party']
            ctg['AGE'] = 16
            ctg['GAME_TYPE']['ONLINE']
            ctg['GAME_TYPE']['OFFLINE'] = ['true']

            name = f'Мафия. Город Засыпает'
            url = f'https://www.ozon.ru/product/mafiya-gorod-zasypaet-148541805/?asb=QH7TCSegQcXVHbYHBJYM7LKhtdxwG%252BVRoAPCitoFqlhnpmUN%252FFssSI0vlK6XPITO&asb2=Xy3Lfwyj0JFNfKL63aHD310HF0Wg_EMUS2Yzk15F-oa12uWlDnOx2OdvI2HNr0ZmkJMsfm0OKKRsuVZYm4bXIosw843ahVEZrJt0l2JPF9ha6oDuKIyMRBscQAL7YmvjK9Ks6fnQ7Zbn3nVyMCVt4g&sh=rkEx2tHLPg'
            desc = f'Универсальное решение для большой компании любителей нуарных детективов! Перед вами особый выпуск популярной психологической игры Мафия от издательства GaGa Games. Мрачные, но стильные иллюстрации зададут тон вашей партии, и правдоподобно сыграть доставшегося вам персонажа не составит труда. Ход игры неизменен: ночами преступники творят беспредел и стремятся сократить число мирных жителей до критически малого, днем законопослушные граждане пытаются навести в городе порядок своими силами и вычислить всех членов мафиозного клана. Опытный ведущий с бурной фантазией контролирует процесс, но в комплект не входит. Все роли скрыты, и чтобы узнать, кто есть кто, придется прислушаться к интуиции, прибегнуть к дедукции и теории лжи. Будьте внимательны к мелочам, активно отстаивайте свою точку зрения и получайте удовольствие от общения!'
            app = AddApp(name, url, desc, ctg, id)
            data.append(app.write())
        except:
            pass
        finally:
            json.dump(data, file, indent=4, sort_keys=True, separators=(',', ' : '), ensure_ascii=False)

