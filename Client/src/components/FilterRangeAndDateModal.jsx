import { useState } from "react";
import DatePicker from "./DatePicker";
import Modal from "./Modal";
import { Button } from "./ui/button";
import { Input } from "./ui/input";
import { Label } from "./ui/label";

function FilterRangeAndDateModal({
  from,
  to,
  setFrom,
  setTo,
  open,
  setOpen,
  distance,
  setDistance,
}) {
  const [range, setRange] = useState(distance);
  const onApply = () => {
    if (
      new Date(from) <= new Date(to) &&
      distance > 0 &&
      new Date() <= new Date(from)
    ) {
      setOpen(false);
      setDistance(range);
    } else {
      alert(
        "Please ensure the start date is today or later, and does not exceed the end date."
      );
    }
  };
  return (
    <Modal isOpen={open} onClose={onApply}>
      <div className="flex flex-col justify-center items-center ">
        <DatePicker date={from} setDate={setFrom}></DatePicker>
        <DatePicker date={to} setDate={setTo}></DatePicker>
        <div className=" w-full">
          <Label className="text-white">Distance</Label>
          <div className="flex">
            <Input
              type="number"
              placeholder={range}
              value={range}
              onChange={(e) => setRange(e.target.value)}
              className="text-center bg-stone-800 text-white text-lg"
            />
            <Button onClick={onApply}>Apply</Button>
          </div>
        </div>
      </div>
    </Modal>
  );
}

export default FilterRangeAndDateModal;
