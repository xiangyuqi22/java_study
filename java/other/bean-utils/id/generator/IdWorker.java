package id.generator;

/**
 * <PRE>
 * ID���������֮ѩ���㷨
 * </PRE>
 *
 * ��Ŀ���ƣ�demo</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��4��
 * @author xiangning
 * @since JDK1.8
 */
public class IdWorker {
	private final long workerId;
	private final long snsEpoch = 1330328109047L;
	private long sequence = 0L;
	private final long workerIdBits = 10L;
	private final long maxWorkerId = -1L ^ -1L << this.workerIdBits;
	private final long sequenceBits = 12L;
	private final long workerIdShift = this.sequenceBits;
	private final long timestampLeftShift = this.sequenceBits + this.workerIdBits;
	private final long sequenceMask = -1L ^ -1L << this.sequenceBits;
	private long lastTimestamp = -1L;

	public IdWorker(long workerId) {
		super();
		if (workerId > this.maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", this.maxWorkerId));
		}
		this.workerId = workerId;
	}

	public synchronized long nextId() throws Exception {
		long timestamp = this.timeGen();
		if (this.lastTimestamp == timestamp) {
			this.sequence = this.sequence + 1 & this.sequenceMask;
			if (this.sequence == 0) {
				timestamp = this.tilNextMillis(this.lastTimestamp);
			}
		} else {
			this.sequence = 0;
		}
		if (timestamp < this.lastTimestamp) {
			throw new Exception(String.format("Clock moved backwards.Refusing to generate id for %d milliseconds",
					(this.lastTimestamp - timestamp)));
		}
		this.lastTimestamp = timestamp;
		return timestamp - this.snsEpoch << this.timestampLeftShift | this.workerId << this.workerIdShift
				| this.sequence;
	}

	/**
	 * ��֤���صĺ������ڲ���֮��
	 *
	 * @param lastTimestamp
	 * @return
	 */
	private long tilNextMillis(long lastTimestamp) {
		long timestamp = this.timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = this.timeGen();
		}
		return timestamp;
	}

	/**
	 * ���ϵͳ��ǰ������
	 *
	 * @return
	 */
	private long timeGen() {
		return System.currentTimeMillis();
	}

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		System.out.println(System.currentTimeMillis());
		boolean flag = false;
		while (flag) {
			Integer workId = 1;
			IdWorker idWork = new IdWorker(workId);
			try {
				System.out.println(String.valueOf(idWork.nextId()));
				Long end = System.currentTimeMillis();
				if(start<=(end-1000)) {
					flag = false;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
