package cn.tx.service.impl;

import cn.tx.dao.DistrictDao;
import cn.tx.dao.impl.DistrictDaoImpl;
import cn.tx.model.District;
import cn.tx.service.DistrictService;
import com.alibaba.fastjson.JSONArray;

import java.util.List;

/**
 * @author Administrator
 * @title: DistrictServiceImpl
 * @projectName tx_eim
 * @description: TODO
 * @date 2019/6/2820:18
 */
public class DistrictServiceImpl implements DistrictService {
    DistrictDao districtDao = new DistrictDaoImpl();
    @Override
    public JSONArray listDistricts() {
        List<District> list = districtDao.listDistricts();
        JSONArray jsonArray = (JSONArray) JSONArray.toJSON(list);
        return jsonArray;
    }
}
