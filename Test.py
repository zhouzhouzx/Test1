__author__ = 'zhouxuan-s'

import requests
import json
import xlrd
class ReadExcel(object):
    def __init__(self,path):
        self.path=path

    
    def getSheet(self):

        xl=xlrd.open_workbook(self.path)
        sheet=xl.sheet_by_index(0)
        return sheet


    def getRows(self):

        row=self.getSheet.nrows
        return  row

  
    def getCol(self):

        col=self.getSheet.ncols
        return col


   
    def getName(self):
        TestName=[]
        for i in range(1,self.getRows):
            TestName.append(self.getSheet.cell_value(i,0))
        return TestName


    def getData(self):
        TestData=[]
        for i in range(1,self.getRows):
            TestData.append(self.getSheet.cell_value(i,1))
        return TestData

   
    def getUrl(self):
        TestUrl=[]
        for i in range(1,self.getRows):
            TestUrl.append(self.getSheet.cell_value(i,2))
        return TestUrl

    
    def getMethod(self):
        TestMethod=[]
        for i in range(1,self.getRows):
            TestMethod.append(self.getSheet.cell_value(i,3))
        return TestMethod

   
    def getCode(self):
        TestCode=[]
        for i in range(1,self.getRows):
            TestCode.append(self.getSheet.cell_value(i,4))
        return TestCode


class TestApi(object):
    def __init__(self,method,url,data):
        self.method=method
        self.url=url
        self.data=data


    @property
    def test(self):

       # try:
            if self.method=='post':
                if self.data:
                     r=requests.post(self.url,data=json.dump(eval(self.data)))

                else:
                     r=requests.post(self.url,"")
                result=r.json()
                print(r.status_code)
                
            elif self.method=='get':
                r=requests.get(self.url,params=eval(self.data))
                result=r.json()
                print(r.status_code)
            return r
       

        #except:
          #  print('失败')

    def getCode(self):

        code=self.test.json()['error']
        return  code

    def getJson(self):

        json_data=self.test.json()
        return  json_data



if '__name__' == '__main__':
    TestApi('post','http://www.baidu.com','{modid=156}')
    

api= TestApi('post','http://mod.game.360.cn/api/mod/unsubscribe','')
apicode=api.getCode()
apijson=api.getJson()

