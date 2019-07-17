package com.hj.entity.leave;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.hj.entity.leave.BO.*;
import com.hj.entity.leave.DTO.*;
import com.hj.util.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author huangjie
 * @time 2019-06-19 15:23
 */
public class Test {
//    public static void main(String[] args) {
//        //日程表 - 我的请假 返回数据
//        ResultData<Page<LeaveCalendarListDTO>>  resultData = new ResultData<>();
//        LeaveCalendarListDTO leaveCalendarListDTO = new LeaveCalendarListDTO();
//        leaveCalendarListDTO.setId(1);
//        leaveCalendarListDTO.setLeaveBeginTime(DateUtil.dateToString(new Date()));
//        leaveCalendarListDTO.setLeaveEndTime(DateUtil.dateToString(new Date()));
//        leaveCalendarListDTO.setApplyForTime(DateUtil.dateToString(new Date()));
//        leaveCalendarListDTO.setLeaveReason("个人原因");
//        leaveCalendarListDTO.setLeaveStatus(0);
//        List<LeaveCalendarListDTO> leaveCalendarListDTOList = Lists.newArrayList();
//        leaveCalendarListDTOList.add(leaveCalendarListDTO);
//
//        Page<LeaveCalendarListDTO> leaveCalendarListDTOPage = new Page<LeaveCalendarListDTO>(1,10);
//        leaveCalendarListDTOPage.setList(leaveCalendarListDTOList);
//        leaveCalendarListDTOPage.setTotalRecord(100);
//
//        resultData.setData(leaveCalendarListDTOPage);
//
//        String s = JSON.toJSONString(resultData);
//        System.out.println("日程表 - 我的请假 返回数据："+s);
//
//
//        //排课-请假记录
//        LeaveListBaseDTO leaveRecordArrangingListDTO = new LeaveListBaseDTO();
//        leaveRecordArrangingListDTO.setId(1);
//        leaveRecordArrangingListDTO.setApplyForTime(DateUtil.dateToString(new Date()));
//        leaveRecordArrangingListDTO.setAuditTime(DateUtil.dateToString(new Date()));
//        leaveRecordArrangingListDTO.setAuditUserId(1);
//        leaveRecordArrangingListDTO.setAuditUserName("张三");
//        leaveRecordArrangingListDTO.setCreatorName("李四");
//        leaveRecordArrangingListDTO.setCreatorUserId(1);
//        leaveRecordArrangingListDTO.setLeaveStatus(0);
//        leaveRecordArrangingListDTO.setTeacherId(1);
//        leaveRecordArrangingListDTO.setLeaveBeginTime(DateUtil.dateToString(new Date()));
//        ArrayList<LeaveListBaseDTO> leaveRecordArrangingListDTOList = Lists.newArrayList();
//        leaveRecordArrangingListDTOList.add(leaveRecordArrangingListDTO);
//
//        Page<LeaveListBaseDTO> leaveRecordArrangingListDTOPage = new Page<>(1, 10);
//        leaveRecordArrangingListDTOPage.setList(leaveRecordArrangingListDTOList);
//        leaveRecordArrangingListDTOPage.setTotalRecord(100);
//
//        ResultData<Page<LeaveListBaseDTO>>  resultData1 = new ResultData<>();
//        resultData1.setData(leaveRecordArrangingListDTOPage);
//
//
//        String s1 = JSON.toJSONString(resultData1);
//        System.out.println("排课-请假记录: "+s1);
//
//
//
//        //请假管理列表
//        LeaveListDTO leaveListDTO = new LeaveListDTO();
//        leaveListDTO.setId(1);
//        leaveListDTO.setApplyForTime(DateUtil.dateToString(new Date()));
//        leaveListDTO.setAuditTime(DateUtil.dateToString(new Date()));
//        leaveListDTO.setAuditUserId(1);
//        leaveListDTO.setAuditUserName("王五");
//        leaveListDTO.setCreatorName("赵六");
//        leaveListDTO.setCreatorUserId(1);
//        leaveListDTO.setLeaveStatus(1);
//        leaveListDTO.setTeacherId(1);
//        leaveListDTO.setTeacherRealName("111");
//        leaveListDTO.setTeacherUserName("222");
//        ArrayList<LeaveListDTO> leaveListDTOList = Lists.newArrayList();
//        leaveListDTOList.add(leaveListDTO);
//
//        Page<LeaveListDTO> leaveListDTOPage = new Page<>(1, 10);
//        leaveListDTOPage.setList(leaveListDTOList);
//        leaveListDTOPage.setTotalRecord(100);
//
//        ResultData<Page<LeaveListDTO>>  resultData2 = new ResultData<>();
//        resultData2.setData(leaveListDTOPage);
//
//
//        String s2 = JSON.toJSONString(resultData2);
//        System.out.println("请假管理列表: "+s2);
//
//
//
//        //日程表 - 影响学员的列表 返回数据
////        LeaveStudentInfoDTO leaveStudentInfoDTO = new LeaveStudentInfoDTO();
////        leaveStudentInfoDTO.setLessonTheme("爱学习");
////        leaveStudentInfoDTO.setOrignalLessonEndTime(DateUtil.dateToString(new Date()));
////        leaveStudentInfoDTO.setOrignalLessonStartTime(DateUtil.dateToString(new Date()));
////        leaveStudentInfoDTO.setStudentName("小明");
////
////        ResultData<List<LeaveStudentInfoDTO>>  resultData4 = new ResultData<>();
////
////        List<LeaveStudentInfoDTO> leaveStudentInfoDTOList = Lists.newArrayList();
////        leaveStudentInfoDTOList.add(leaveStudentInfoDTO);
////
////        resultData4.setData(leaveStudentInfoDTOList);
////
////        String s3 = JSON.toJSONString(resultData4);
////
////        System.out.println("日程表 - 影响学员的列表 返回数据:"+s3);
//
//
//
//
//
//
//
//        //查看请假详情
//        ResultData<LeaveAllInfoDTO>  resultDataInfo = new ResultData<>();
//
//        LeaveAllInfoDTO leaveInfoDTO = new LeaveAllInfoDTO();
//
//
//        LeaveTeacherInfoBO leaveTeacherInfoBO = new LeaveTeacherInfoBO();
//        leaveTeacherInfoBO.setSex(1);
//        leaveTeacherInfoBO.setTeacherCode("qwe123");
//        leaveTeacherInfoBO.setTeacherNature(1);
//        leaveTeacherInfoBO.setTeacherRealName("qweqwewq");
//        leaveTeacherInfoBO.setTeacherType(1);
//        leaveTeacherInfoBO.setTeacherUserName("qweqw");
//
//        leaveInfoDTO.setLeaveTeacherInfo(leaveTeacherInfoBO);
//
//
//
//
//
//        LeaveAuditInfoBO leaveAuditInfoBO = new LeaveAuditInfoBO();
//        leaveAuditInfoBO.setAuditRemark("123");
//        leaveAuditInfoBO.setAuditStatus(1);
//        leaveAuditInfoBO.setAuditTime(DateUtil.dateToString(new Date()));
//        leaveAuditInfoBO.setAuditUserName("张三");
//
//        leaveInfoDTO.setLeaveAuditInfo(leaveAuditInfoBO);
//
//
//
//
//
//
//
//        LeaveInfoBO leaveInfoBO = new LeaveInfoBO();
//        leaveInfoBO.setCreatorName("李老师");
//        leaveInfoBO.setLeaveBeginTime(DateUtil.dateToString(new Date()));
//        leaveInfoBO.setLeaveEndTime(DateUtil.dateToString(new Date()));
//        leaveInfoBO.setLeaveReason("qwe");
//        leaveInfoBO.setApplyForTime(DateUtil.dateToString(new Date()));
//
//        leaveInfoDTO.setLeaveInfo(leaveInfoBO);
//
//
//
//
//
//
//        LeaveTeaminateInfoBO leaveTeaminateInfoBO = new LeaveTeaminateInfoBO();
//        leaveTeaminateInfoBO.setLeaveTeaminateBeginTime(DateUtil.dateToString(new Date()));
//        leaveTeaminateInfoBO.setLeaveTeaminateEndTime(DateUtil.dateToString(new Date()));
//        leaveTeaminateInfoBO.setLeaveTeaminateOperateTime(DateUtil.dateToString(new Date()));
//        leaveTeaminateInfoBO.setLeaveTeaminateOperateUserName("123");
//        leaveTeaminateInfoBO.setLeaveTeaminateReason("12312312");
//
//        leaveInfoDTO.setLeaveTeaminateInfo(leaveTeaminateInfoBO);
//
//
//
//
//
//
//        LeaveUndoInfoBO leaveUndoInfoBO = new LeaveUndoInfoBO();
//        leaveUndoInfoBO.setLeaveUndoOperateTime(DateUtil.dateToString(new Date()));
//        leaveUndoInfoBO.setLeaveUndoOperateUserName("123");
//        leaveUndoInfoBO.setLeaveUndoReason("asdasdas");
//
//        leaveInfoDTO.setLeaveUndoInfo(leaveUndoInfoBO);
//
//
//
//
//
//
//        LeaveStudentInfoBO leaveStudentInfoBO = new LeaveStudentInfoBO();
////        leaveStudentInfoBO.setClassSwitchInfo("调课至："+DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO.setClasseApply(0);
//        leaveStudentInfoBO.setClassSwitchBeginTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO.setClassSwitchEndTime(DateUtil.dateToString(new Date()));
//
//        leaveStudentInfoBO.setClassSwitchResult("取消");
//        leaveStudentInfoBO.setClassSwitchStatus(0);
//        leaveStudentInfoBO.setLessonTheme("爱学习");
//        leaveStudentInfoBO.setOrignalLessonEndTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO.setOrignalLessonStartTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO.setStudentCompensation(0.5D);
//        leaveStudentInfoBO.setStudentName("小黑");
//        leaveStudentInfoBO.setTeacherDeduct(1D);
//
//        ArrayList<LeaveStudentInfoBO> leaveStudentInfoBOs = Lists.newArrayList();
//
//        leaveStudentInfoBOs.add(leaveStudentInfoBO);
//
//
//        leaveInfoDTO.setLeaveStudentInfos(leaveStudentInfoBOs);
//
//
//
//
//        resultDataInfo.setData(leaveInfoDTO);
//
//        String s4 = JSON.toJSONString(resultDataInfo);
//
//        System.out.println("查看请假详情: "+s4);
//
//        String s5 = JSON.toJSONString(leaveInfoDTO);
//        System.out.println("查看请假详情 没有reault:"+s5);
//
//
//        //----------撤销
//        LeaveUndoInfoDTO leaveUndoInfoDTO = new LeaveUndoInfoDTO();
//
//        LeaveInfoBO leaveInfoBO1 = new LeaveInfoBO();
//        leaveInfoBO1.setCreatorName("李老师");
//        leaveInfoBO1.setLeaveBeginTime(DateUtil.dateToString(new Date()));
//        leaveInfoBO1.setLeaveEndTime(DateUtil.dateToString(new Date()));
//        leaveInfoBO1.setLeaveReason("qwe");
//        leaveInfoBO1.setApplyForTime(DateUtil.dateToString(new Date()));
//
//        leaveUndoInfoDTO.setLeaveInfo(leaveInfoBO1);
//
//
//
//        LeaveAuditInfoBO leaveAuditInfoBO1 = new LeaveAuditInfoBO();
//        leaveAuditInfoBO1.setAuditRemark("123");
//        leaveAuditInfoBO1.setAuditStatus(1);
//        leaveAuditInfoBO1.setAuditTime(DateUtil.dateToString(new Date()));
//        leaveAuditInfoBO1.setAuditUserName("张三");
//
//        leaveUndoInfoDTO.setLeaveAuditInfo(leaveAuditInfoBO1);
//
//        ResultData<LeaveUndoInfoDTO> resultData3 = new ResultData<LeaveUndoInfoDTO>();
//        resultData3.setData(leaveUndoInfoDTO);
//
//        String s3 = JSON.toJSONString(resultData3);
//
//        System.out.println("撤销："+s3);
//
//
//
//
//
//        //--------单个审核弹窗
//
//        LeaveAllInfoDTO leaveInfoDTO1 = new LeaveAllInfoDTO();
//
//
//        LeaveTeacherInfoBO leaveTeacherInfoBO1 = new LeaveTeacherInfoBO();
//        leaveTeacherInfoBO1.setSex(1);
//        leaveTeacherInfoBO1.setTeacherCode("qwe123");
//        leaveTeacherInfoBO1.setTeacherNature(1);
//        leaveTeacherInfoBO1.setTeacherRealName("qweqwewq");
//        leaveTeacherInfoBO1.setTeacherType(1);
//        leaveTeacherInfoBO1.setTeacherUserName("qweqw");
//
//        leaveInfoDTO1.setLeaveTeacherInfo(leaveTeacherInfoBO1);
//
//
//        LeaveInfoBO leaveInfoBO12 = new LeaveInfoBO();
//        leaveInfoBO12.setCreatorName("李老师");
//        leaveInfoBO12.setLeaveBeginTime(DateUtil.dateToString(new Date()));
//        leaveInfoBO12.setLeaveEndTime(DateUtil.dateToString(new Date()));
//        leaveInfoBO12.setLeaveReason("qwe");
//        leaveInfoBO12.setApplyForTime(DateUtil.dateToString(new Date()));
//
//        leaveInfoDTO1.setLeaveInfo(leaveInfoBO12);
//
//
//
//        LeaveStudentInfoBO leaveStudentInfoBO1 = new LeaveStudentInfoBO();
////        leaveStudentInfoBO1.setClassSwitchInfo("调课至："+DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO1.setClasseApply(0);
//        leaveStudentInfoBO1.setClassSwitchBeginTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO1.setClassSwitchEndTime(DateUtil.dateToString(new Date()));
//
//        leaveStudentInfoBO1.setClassSwitchResult("取消");
//        leaveStudentInfoBO1.setClassSwitchStatus(0);
//        leaveStudentInfoBO1.setLessonTheme("爱学习");
//        leaveStudentInfoBO1.setOrignalLessonEndTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO1.setOrignalLessonStartTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO1.setStudentCompensation(0.5D);
//        leaveStudentInfoBO1.setStudentName("小黑");
//        leaveStudentInfoBO1.setTeacherDeduct(1D);
//
//        ArrayList<LeaveStudentInfoBO> leaveStudentInfoBOs1 = Lists.newArrayList();
//
//        leaveStudentInfoBOs1.add(leaveStudentInfoBO1);
//
//
//        leaveInfoDTO1.setLeaveStudentInfos(leaveStudentInfoBOs1);
//
//
//        ResultData<LeaveAllInfoDTO> resultData4 = new ResultData<LeaveAllInfoDTO>();
//        resultData4.setData(leaveInfoDTO1);
//
//        String s6 = JSON.toJSONString(resultData4);
//
//        System.out.println("单个审核弹窗："+s6);
//
//
//
//
//        //--------------批量审核弹窗-------------
//
//        LeaveAllInfoDTO leaveInfoDTO2 = new LeaveAllInfoDTO();
//
//
//        LeaveTeacherInfoBO leaveTeacherInfoBO2 = new LeaveTeacherInfoBO();
//        leaveTeacherInfoBO2.setTeacherRealName("张三");
//        leaveTeacherInfoBO2.setTeacherUserName("zhangsan");
//        leaveInfoDTO2.setLeaveTeacherInfo(leaveTeacherInfoBO2);
//
//        LeaveInfoBO leaveInfoBO2 = new LeaveInfoBO();
//        leaveInfoBO2.setLeaveBeginTime(DateUtil.dateToString(new Date()));
//        leaveInfoBO2.setLeaveEndTime(DateUtil.dateToString(new Date()));
//        leaveInfoBO2.setLeaveReason("asdasdasdasda");
//        leaveInfoDTO2.setLeaveInfo(leaveInfoBO2);
//
//
//        LeaveStudentInfoBO leaveStudentInfoBO2 = new LeaveStudentInfoBO();
////        leaveStudentInfoBO2.setClassSwitchInfo("调课至："+DateUtil.dateToString(new Date()));
//
//        leaveStudentInfoBO2.setClasseApply(0);
//        leaveStudentInfoBO2.setClassSwitchBeginTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO2.setClassSwitchEndTime(DateUtil.dateToString(new Date()));
//
//        leaveStudentInfoBO2.setClassSwitchResult("取消");
//        leaveStudentInfoBO2.setClassSwitchStatus(0);
//        leaveStudentInfoBO2.setLessonTheme("爱学习");
//        leaveStudentInfoBO2.setOrignalLessonEndTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO2.setOrignalLessonStartTime(DateUtil.dateToString(new Date()));
//        leaveStudentInfoBO2.setStudentCompensation(0.5D);
//        leaveStudentInfoBO2.setStudentName("小黑");
//        leaveStudentInfoBO2.setTeacherDeduct(1D);
//        leaveStudentInfoBO2.setTeacherId(1);
//
//        ArrayList<LeaveStudentInfoBO> leaveStudentInfoBOs2 = Lists.newArrayList();
//
//        leaveStudentInfoBOs2.add(leaveStudentInfoBO2);
////        leaveInfoDTO2.setLeaveStudentInfos(leaveStudentInfoBOs2);
//
//        LeaveBatchReviewDTO leaveBatchReviewDTO = new LeaveBatchReviewDTO();
//
//        List<LeaveAllInfoDTO> leaveAllInfoDTOs = Lists.newArrayList();
//        leaveAllInfoDTOs.add(leaveInfoDTO2);
//
//        leaveBatchReviewDTO.setLeaveAllInfoS(leaveAllInfoDTOs);
//        leaveBatchReviewDTO.setLeaveStudentInfos(leaveStudentInfoBOs2);
//
//        ResultData<LeaveBatchReviewDTO> objectResultData = new ResultData<>();
//        objectResultData.setData(leaveBatchReviewDTO);
//
//        String s7 = JSON.toJSONString(objectResultData);
//        System.out.println("批量审核弹窗："+s7);
//
//
//
//
//        //----------------操作日志
//        OperationLogDTO operationLogDTO = new OperationLogDTO();
//        operationLogDTO.setOperateDescription("21312312312");
//        operationLogDTO.setOperateReason("12312312312312");
//        operationLogDTO.setOperateType(1);
//        operationLogDTO.setOperationLogId(1);
//        operationLogDTO.setOperatorId(1);
//        operationLogDTO.setOperatorName("张三");
//
//
//        List<OperationLogDTO> operationLogs = Lists.newArrayList();
//        operationLogs.add(operationLogDTO);
//
//
//
//
//        Page<OperationLogDTO> OperationLogPage = new Page<OperationLogDTO>(1,10);
//        OperationLogPage.setList(operationLogs);
//        OperationLogPage.setTotalRecord(100);
//
//
//
//        ResultData<Page<OperationLogDTO>> objectResultData1 = new ResultData<>();
//        objectResultData1.setData(OperationLogPage);
//
//        String s8 = JSON.toJSONString(objectResultData1);
//
//        System.out.println("操作日志："+s8);
//
//
//
//        //选择教师列表-------------
//        LeaveTeacherInfoBO leaveTeacherInfoBO3 = new LeaveTeacherInfoBO();
//        leaveTeacherInfoBO3.setSex(1);
//        leaveTeacherInfoBO3.setTeacherCode("qwe123");
//        leaveTeacherInfoBO3.setTeacherNature(1);
//        leaveTeacherInfoBO3.setTeacherRealName("qweqwewq");
//        leaveTeacherInfoBO3.setTeacherType(1);
//        leaveTeacherInfoBO3.setTeacherUserName("qweqw");
//        leaveTeacherInfoBO3.setTeacherId(1);
//
//
//        List<LeaveTeacherInfoBO> leaveTeacherInfos = Lists.newArrayList();
//        leaveTeacherInfos.add(leaveTeacherInfoBO3);
//
//        ResultData<List<LeaveTeacherInfoBO>> objectResultData2 = new ResultData<>();
//        objectResultData2.setData(leaveTeacherInfos);
//
//        String s9 = JSON.toJSONString(objectResultData2);
//        System.out.println("选择教师列表："+s9);
//    }
}
