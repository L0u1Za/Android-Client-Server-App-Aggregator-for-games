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
    with open(path, 'r') as file:
        data = json.loads(file.read())
    with open(path, 'w') as file:
        try:
            if (len(data) != 0 and 'ID' in data[-1]):
                id = data[-1]['ID'] + 1
            else:
                id = 1
            ctg = available_categories.copy()
            ctg['EVENT'] = 'Party'
            ctg['AGE'] = 18
            ctg['TIME'] = (10, 20)
            name = 'Among Us'
            url = 'https://play.google.com/store/apps/details?id=com.innersloth.spacemafia&hl=ru&gl=US'
            desc = 'Play online or over local WiFi with 4-15 players as you attempt to prep your spaceship for departure, but beware as one will be an impostor bent on killing everyone! Crewmates can win by completing all tasks or discovering and voting the impostor off the ship. The Impostor can use sabotage to cause chaos, making for easier kills and better alibis.'
            app = AddApp(name, url, desc, ctg, id)
            data.append(app.write())
        except:
            pass
        finally:
            json.dump(data, file, indent=4, sort_keys=True, separators=(',', ' : '), ensure_ascii=False)

