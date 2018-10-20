import requests
import sys
import re

url = f"https://isbndb.com/book/{sys.argv[1]}"

resp = requests.get(url)

start = re.search("<table", resp.text).start()
end = re.search("</table>", resp.text).end()

table_text = resp.text[start:end]
lines = table_text.split("\n")
clean_lines = [line.strip() for line in lines if line.strip() != ""]

title_line = [item for item in clean_lines if "Full Title" in item][0]
title = re.findall("<td>(.+)</td>", title_line)[0]

isbn13_line = [item for item in clean_lines if "ISBN13" in item][0]
isbn13 = re.findall("<td>(.+)</td>", isbn13_line)[0]

author_line_index = [i for i in range(len(clean_lines)) if "Authors" in clean_lines[i]][0]
author_lines = clean_lines[author_line_index: author_line_index + 3]
author_info = "".join(author_lines)
author = re.findall("<a href.+?>(.+?)<", author_info)[0]

print(f"{title}\n{author}")
