package com.cn.ServiceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.Dao.UserDao;
import com.cn.Entity.UserEntity;
import com.cn.Service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	// 一键导入用户
	public void adduser(String file) {
		// TODO Auto-generated method stub

		try {
			InputStream is = new FileInputStream(file);
			XSSFWorkbook workbook = new XSSFWorkbook(is);

			// 循环工作表
			for (int numSheet = 0; numSheet < workbook.getNumberOfSheets(); numSheet++) {

				XSSFSheet sheet = workbook.getSheetAt(numSheet);

				if (sheet == null) {
					continue;
				}

				// 循环行
				for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
					XSSFRow row = sheet.getRow(rowNum);
					if (row != null) {
						XSSFCell userName = row.getCell(0);
						XSSFCell andName = row.getCell(1);
						XSSFCell password = row.getCell(2);
						XSSFCell gustId = row.getCell(3);
						
						userDao.adduser(getValue(userName), getValue(andName), getValue(password),
								Integer.valueOf(Math.round(Float.valueOf(getValue(gustId)))).intValue());
						is.close();
					}

				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@SuppressWarnings("static-access")
	private String getValue(XSSFCell xssfCell) {
		// TODO Auto-generated method stub
		if (xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(xssfCell.getBooleanCellValue());
		} else if (xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值
			Double d = xssfCell.getNumericCellValue();
			Integer i = Integer.valueOf(Math.round(Double.valueOf(d).intValue()));
			Double b = Double.valueOf(Math.round(Double.valueOf(i).doubleValue()));
			if (d.equals(b)) {
				return String.valueOf(i);
			} else
				return String.valueOf(d);
		} else {
			// 返回字符串类型的值
			return String.valueOf(xssfCell.getStringCellValue());
		}
	}

	// 查询用户
	@Override
	public UserEntity selectName(String userName) {
		// TODO Auto-generated method stub

		return userDao.selectName(userName);
	}

	// 修改昵称
	@Override
	public void updateName(int id, String andName) {
		// TODO Auto-generated method stub
		userDao.updateName(id, andName);
	}

	@Override
	public void updatePassword(int id, String password) {
		// TODO Auto-generated method stub
		userDao.updatePassword(id, password);
	}

}
