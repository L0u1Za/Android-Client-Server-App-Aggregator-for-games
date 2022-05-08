import json

path = 'game_list.json'

if __name__ == '__main__':
    with open(path, 'r') as file:
        data = json.loads(file.read())
    with open(path, 'w') as file:
        id = 1
        try:
            for it in data:
                if ('ID' in it and it['ID'] == id):
                    data.remove(it)
                    break
        except:
            pass
        finally:
            json.dump(data, file, indent=4, sort_keys=True, separators=(',', ' : '), ensure_ascii=False)